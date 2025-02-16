import React from "react";
import image from "./assets/logo.png"
import HomeLogo from "./HomeLogo.jsx";
import SearchBar from './SearchBar.jsx'
import InstallApp from "./InstallApp.jsx";

const NavigationBar = () => {
    return (
        <div className="navBar">
            <img src={image} alt="Spotify logo" width={50} height={50}></img>
            <HomeLogo/>
            <SearchBar/>
            <InstallApp/>
            {/* <SignUp/>
            <LogIn/>
            <Menu/> */}
        </div>
    )
}

export default NavigationBar;