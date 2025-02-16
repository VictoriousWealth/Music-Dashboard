import React from "react";
import image from './assets/homeLogo.png'

const HomeLogo = () => {
    return <div className="homeLogo">
        <img src={image} alt="Home Logo" width={50} height={50}></img>
    </div>
}

export default HomeLogo;