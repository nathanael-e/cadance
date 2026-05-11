import { useState } from 'react'
import './GoalChat.css'

type Message = {
  role: 'user' | 'assistant'
  content: string
}

const GoalChat = () => {
  const [messages, setMessages] = useState<Message[]>([
    {
      role: 'assistant',
      content: "Welcome! Let's define your training goal before building your plan."
    },
    {
      role: 'assistant',
      content: "A good goal is SMART — Specific (what event and distance?), Measurable (what target time?), Achievable (realistic for your current fitness), Relevant (something you actually care about), and Time-bound (when is your race or deadline?). For example: \"Run a sub-2:00 half marathon by October 12th 2026.\""
    },
    {
      role: 'assistant',
      content: "What are you working towards?"
    }
  ])
  const [input, setInput] = useState('')
  const [loading, setLoading] = useState(false)

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault()
    if (!input.trim() || loading) return

    const userMessage: Message = { role: 'user', content: input }
    const updatedMessages = [...messages, userMessage]
    setMessages(updatedMessages)
    setInput('')
    setLoading(true)

    // TODO: call backend
    setLoading(false)
  }

  return (
    <div className="goal-chat">
      <ul className="goal-chat-messages">
        {messages.map((msg, i) => (
          <li key={i} className={`goal-chat-message goal-chat-message--${msg.role}`}>
            {msg.content}
          </li>
        ))}
        {loading && (
          <li className="goal-chat-message goal-chat-message--assistant goal-chat-message--loading">
            ...
          </li>
        )}
      </ul>
      <form className="goal-chat-form" onSubmit={handleSubmit}>
        <div className="goal-chat-input-wrapper">
          <textarea
            className="goal-chat-input"
            value={input}
            onChange={e => setInput(e.target.value)}
            placeholder="Type your goal..."
            rows={2}
            onKeyDown={e => {
              if (e.key === 'Enter' && !e.shiftKey) {
                e.preventDefault()
                handleSubmit(e)
              }
            }}
          />
          <button className="goal-chat-submit" type="submit" disabled={loading}>
            Send
          </button>
        </div>
      </form>
    </div>
  )
}

export default GoalChat
