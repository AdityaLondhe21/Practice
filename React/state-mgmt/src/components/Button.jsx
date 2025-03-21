import React, { useContext } from 'react'
import CompA from './CompA'
import CompB from './CompB'
import { countCtx } from '../state/context'

function Button({count}) {
    const obj = useContext(countCtx)

    function incrCount(){
        obj.setCount(obj.count+1)
    }
  return (
    <div>
      <h2>Clickable Button : {obj.count}</h2>
      <button onClick={incrCount} >CLICK HERE : {obj.count}</button>
      <CompA count={count}/>
      <CompB/>
    </div>
  )
}

export default Button
