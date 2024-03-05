
import './App.css'
import Hello from './pages/Hello'

import RegisterPage from './pages/RegisterPage'
import {BrowserRouter, Route, Routes} from 'react-router-dom'

function App() {
 

  return (
   
    
    <BrowserRouter>
  <Routes>
    <Route path="/registerpage" element={<RegisterPage/>} />
    <Route path="/hello" element={<Hello/>} />
  </Routes>
</BrowserRouter>
    
      
  )
}

export default App
