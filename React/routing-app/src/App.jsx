import { useState } from 'react'
import { Route, Routes } from 'react-router-dom'
import Home from './screens/Home'
import About from './screens/About'
import Contact from './screens/Contact'
import NetBanking from './screens/NetBanking'
import Services from './screens/Services'
import Welcome from './screens/Welcome'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <Routes>
        <Route path='/' element={<Home/>}/>
        <Route path='/about' element={<About/>}/>
        <Route path='/contact' element={<Contact/>}/>
        <Route path='/netbanking' element={<NetBanking/>}/>
        <Route path='/services' element={<Services/>}/>
        <Route path='/welcome' element={<Welcome/>}/>
      </Routes>
    </>
  )
}

export default App
