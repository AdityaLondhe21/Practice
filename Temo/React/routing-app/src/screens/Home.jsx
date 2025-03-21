import React from 'react'
import Header from '../components/Header'
import Footer from '../components/Footer'
import Title from '../components/Title'
import { useNavigate } from 'react-router-dom'

const Home = () => {
  let flag=true;
  const navigate = useNavigate();
  function goTo(){
    if(flag){
      navigate('/netbanking')
    }
    else{
      navigate('/about')
    }
  }
  return (
    <div>
      <Header/>
      <Title msg="Welcome to out national bank"/>
      
      <button onClickCapture={goTo}>Click Here</button>
      <Footer/>
    </div>
  )
}

export default Home
