import React from "react"
import image from './assets/downloadIcon.png'

const InstallApp = () => {
    return (
        <div className="installApp">
            <img src={image} alt="Install App" width={30} height={30}></img>
            <p>Install App</p>
        </div>
    )
}

export default InstallApp