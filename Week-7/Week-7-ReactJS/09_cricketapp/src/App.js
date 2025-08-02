const ListofPlayers = () => {
  const players = [
    { name: "Nandani", score: 80 },
    { name: "Daksh", score: 65 },
    { name: "Shikha", score: 90 },
    { name: "Abhinav", score: 45 },
  ];

  const highScorers = players.filter(p => p.score >= 70);
  const lowScorers = players.filter(p => p.score < 70);

  return (
    <div>
      <h2>All Players</h2>
      <ul>{players.map(p => <li key={p.name}>{p.name} - {p.score}</li>)}</ul>
      <h3>High Scorers (>=70)</h3>
      <ul>{highScorers.map(p => <li key={p.name}>{p.name}</li>)}</ul>
      <h3>Low Scorers (&lt;70)</h3>
      <ul>{lowScorers.map(p => <li key={p.name}>{p.name}</li>)}</ul>
    </div>
  );
};

function App() {
  return (
    <div>
      <ListofPlayers />
    </div>
  );
}

export default App;
