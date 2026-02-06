import './App.css';
import React,{useEffect,useState} from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';


function App() 
{
  //Historical data
  const[selectedStock,setSelectedStock]=useState(null);
  const[history,setHistory]=useState([]);
  const[historyloading,setHistoryLoading]=useState(false);
  const[historyError,setHistoryError]=useState(null);
  
  //Top10 stocks
  const[stocks,setStocks]=useState([]);
  const[loading,setLoading]=useState(true);
  const[error,setError]=useState();

  //AI analysis
  const[analysis,setAnalysis]=useState(null);
  const[analysisLoading,setAnalysisLoading]=useState(false);
  const[analysisError,setAnalysisError]=useState(null);

  //Fetching top10 stocks:
  useEffect(()=>
  {
    axios.get("http://localhost:8080/api/stocks/top10")
    .then(res=>{
    console.log("Stock data",res.data);  
    setStocks(res.data);
    setLoading(false);
    })
    .catch(err=>{
      console.error(err);
      setError("Failed to load data");
      setLoading(false);
    });
  },[]);

  //Getting the history of the ticker
  const loadHistory=(ticker)=>
  {
    setSelectedStock(ticker);
    setHistoryLoading(true);
    setHistoryError(null);

    axios.get(`http://localhost:8080/api/stocks/${ticker}/history`)
    .then(res=>{
      console.log("History API response:", res.data);setHistory(res.data);
      setHistoryLoading(false);
    })
    .catch(err=>{
      console.error(err);
      setHistoryError("Failed to load history data");
      setHistoryLoading(false);
    }
    );
  }

  //AI analysis 
  const analyzeStock=()=>
  {
    setAnalysis(null);
    setAnalysisLoading(true);
    setAnalysisError(null);

    axios.post(`http://localhost:8080/api/stocks/${selectedStock}/analyze`)
    .then(res=>
      { 
      setAnalysis(res.data);
      setAnalysisLoading(false);
      })
    .catch(err=>
      {
        console.error(err);
        setAnalysisError("AI analysis failed");
        setAnalysisLoading(false);
      });
  };

  return (
    <div className="App">
      <div className="container-fluid mt-3">
        <h1  className="text-center mb-4">Top 10 Stocks</h1>
         {loading && <p>Loading data...</p>}
          {error && <p style={{ color: "red" }}>{error}</p>}
          {!loading && !error && (
       <div className="row"> 
        <div className="col-md-8">
          <table className="table table-striped table-bordered">
            <thead className="table-dark">
              <tr>
                <th>Ticker</th>
                <th>Company</th>
                <th>Price</th>
                <th>Change</th>
                <th>Volume</th>
                <th>Details</th>
              </tr>
            </thead>
            <tbody>
              {
                stocks.map((stock,index)=>{
                  return (
                    <tr key={stock.ticker}>
                      <td>{stock.ticker}</td>
                      <td>{stock.company}</td>
                      <td>{stock.price}</td>
                      <td>{stock.change}%</td>
                      <td>{stock.volume}</td>
                      <td>
                        <button className="btn btn-primary btn-sm"
                         onClick={()=>loadHistory(stock.ticker)}>
                          view
                        </button>
                      </td>
                    </tr>
                  )
                })
              }
            </tbody>
          </table>  
        </div>
  
      <div className="col-md-4">
       {selectedStock && (
        <div className="card shadow-sm mb-3">
          <div className="card-body">
           <h4 className="card-title text-center">{selectedStock}-6 Month History</h4>
           {historyloading && <p>Loading history..</p>}
           {historyError && <p style={{color:"red"}}>{historyError}</p>}
           {!historyloading && !historyError && (
           <ul className="list-group list-group-flush">
            {
              history.map((h,index)=>
              {
                return(
                <li key={index} className="list-group-item">
                  {h.date}:${h.price}
                </li>   
                );
               })
            }
           </ul>
          )}
           <button className="btn btn-success w-100 mt-3"
           onClick={analyzeStock}>
           Analyze with AI
           </button>
          </div>
        </div>
        
       )}
      </div>
      </div>
      )}
        {analysisLoading && <p>Analyzing with AI</p>}
        {analysisError && <p style={{color:"red"}}>{analysisError}</p>}

        {analysis && (
      <div className="card shadow-sm">
        <div className="card-body"> 
         <h2 className="card-title text-center">AI analysis</h2>
         <p><strong>Trend:</strong>{analysis.trend}</p>
         <p><strong>Risk:</strong>{analysis.risk}</p>
         <p><strong>Suggestion:</strong>{analysis.action}</p>
         <p className="text-muted"><i>{analysis.disclaimer}</i></p>
        </div>
      </div>
      
        )}
      </div> 
      
    </div>
  
  );
}

export default App;
