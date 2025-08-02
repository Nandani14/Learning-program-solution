import { useState } from "react";

function App() {
  const [loggedIn, setLoggedIn] = useState(false);
  const flights = ["Delhi to Mumbai", "Chennai to Bangalore", "Pune to Goa"];

  return (
    <div>
      <h2>Ticket Booking App</h2>
      <button onClick={() => setLoggedIn(!loggedIn)}>
        {loggedIn ? "Logout" : "Login"}
      </button>
      <ul>
        {flights.map((flight, i) => (
          <li key={i}>
            {flight} {loggedIn && <button>Book</button>}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
