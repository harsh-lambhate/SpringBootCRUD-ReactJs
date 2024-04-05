import React, { useState } from 'react';

function Timer() {
  const [count, setCount] = useState(0);
  const [intervalId, setIntervalId] = useState(null);

  const startTimer = () => {
    const id = setInterval(() => {
      console.log("Start");
      setCount(prevCount => prevCount + 1);
    }, 1000); 
    setIntervalId(id);
  };

  const stopTimer = () => {
    clearInterval(intervalId);
    setIntervalId(null);
  };

  const resetTimer = () => {
    stopTimer();
    setCount(0);
  };

  return (
    <div className='text-center' style={{'marginTop':'10%'}}>
      <h1>Stop Watch</h1>
      <br/>
      <h1>{count}</h1>
      <br/>
      <button className='btn btn-primary' onClick={startTimer} disabled={intervalId !== null}>Start</button>
      <button className='btn btn-danger'  style={{'marginLeft':'20px'}} onClick={stopTimer} disabled={intervalId === null}>Stop</button>
      <button className='btn btn-secondary'  style={{'marginLeft':'20px'}} onClick={resetTimer}>Reset</button>
    </div>
  );
}

export default Timer;
