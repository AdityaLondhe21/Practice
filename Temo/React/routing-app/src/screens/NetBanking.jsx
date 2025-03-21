import React from 'react'

const NetBanking = () => {
  return (
    <div>
      <h2>Net Banking</h2>
      <h3>Please Login</h3>
      <form>
        UserName : <input type="text" /><br />
        Password : <input type="password"/><br />
        <button>Login</button>
        <button type='reset'>Clear</button>
      </form>
    </div>
  )
}

export default NetBanking
