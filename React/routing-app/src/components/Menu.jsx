import React from 'react'
import { Link } from 'react-router-dom'

const Menu = () => {
  return (
    <div>
      <Link to={'/'}>Home</Link><br />
      <Link to={'/about'}>About Us</Link><br />
      <Link to={'/contact'}>Contact Us</Link><br />
      <Link to={'/netbanking'}>NetBanking</Link><br />
      <Link to={'/services'}>Services</Link><br />
    </div>
  )
}

export default Menu
