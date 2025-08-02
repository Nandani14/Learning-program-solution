const OfficeList = () => {
  const offices = [
    { name: "Workspace A", rent: 50000, address: "Sector 5" },
    { name: "Workspace B", rent: 70000, address: "Sector 3" },
  ];

  return (
    <div>
      <h2>Office Space Rentals</h2>
      {offices.map((office, i) => (
        <div key={i} style={{ color: office.rent < 60000 ? "red" : "green" }}>
          <p>{office.name}</p>
          <p>Rent: ₹{office.rent}</p>
          <p>Address: {office.address}</p>
        </div>
      ))}
    </div>
  );
};

function App() {
  return (
    <div>
      <OfficeList />
    </div>
  );
}

export default App;
