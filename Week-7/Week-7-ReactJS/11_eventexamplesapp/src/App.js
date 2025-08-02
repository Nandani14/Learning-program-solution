import { useState } from "react";

function CurrencyConvertor() {
  const [rupees, setRupees] = useState(0);
  const handleSubmit = () => {
    alert("€" + (rupees / 90).toFixed(2));
  };

  return (
    <div>
      <input type="number" value={rupees} onChange={(e) => setRupees(e.target.value)} />
      <button onClick={handleSubmit}>Convert</button>
    </div>
  );
}

function App() {
  const [count, setCount] = useState(0);

  return (
    <div>
      <h2>Counter: {count}</h2>
      <button onClick={() => setCount(count + 1)}>Increment</button>
      <button onClick={() => setCount(count - 1)}>Decrement</button>
      <br /><br />
      <button onClick={() => alert("Welcome!")}>Say Welcome</button>
      <button onClick={() => alert("I was clicked")}>Click Me</button>
      <br /><br />
      <CurrencyConvertor />
    </div>
  );
}

export default App;
