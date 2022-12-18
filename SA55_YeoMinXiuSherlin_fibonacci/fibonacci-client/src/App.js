import React from "react";
import Value from "./Value";

function App() {
  const [number, setNumber] = React.useState(0);
  const [data, setData] = React.useState(null);

    const params = {
        method : "GET",
        headers: {
          accept: 'application/json',
      }
    };

  const query = (num) => {fetch(`http://138.2.93.158:8000/fibonacci?elements=${num}`, params)
      .then((res) => {
        return res.json();
      })
      .then((data) => {
        return setData(data);})};

  return (
    <div className="App">
      Elements: <input type="number" value={number} onChange={e => {setNumber(e.target.value); query(e.target.value);}}/>
    {<Value data={JSON.stringify(data)}/>}
    </div>
  );
}

export default App;
