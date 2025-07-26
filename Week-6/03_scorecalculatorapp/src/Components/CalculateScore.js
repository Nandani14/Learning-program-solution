import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore({ name, school, total, goal }) {
  const average = total / goal;
  return (
    <div className="score-box">
      <h3>{name}</h3>
      <p>School: {school}</p>
      <p>Average Score: {average.toFixed(2)}</p>
    </div>
  );
}

export default CalculateScore;
