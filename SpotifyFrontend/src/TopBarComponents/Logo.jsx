import React from "react";
import image from "../assets/logo.webp";

import "../CSS/TopBar.css"

const Logo = () => {
    return (
        <div className="logo">
            <img src={image} alt="Logo Web App"></img>
        </div>
    )
}

export default Logo;