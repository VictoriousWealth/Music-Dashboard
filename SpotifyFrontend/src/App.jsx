import React from "react";
import TopBar from './MainComponents/TopBar.jsx'
import SideBar from './MainComponents/SideBar.jsx'
import CentreBar from './MainComponents/CentreBar.jsx'

import './App.css'

const App = () => {
  return (
    <div className="app">
      <TopBar/>
      <div className="not-top-bar">
        <SideBar/>
        <CentreBar/>
      </div>
      
    </div>
  );
};

export default App;
