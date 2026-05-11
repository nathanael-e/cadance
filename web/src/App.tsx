import Nav from './components/Nav'
import GoalChat from './components/GoalChat'
import './App.css'

const App = () => {
  return (
    <div className="layout">
      <Nav />
      <main className="main">
        <GoalChat />
      </main>
    </div>
  )
}

export default App
