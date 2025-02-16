import React from "react";
import image from './assets/searchIcon.png'
import BrowseIcon from './BrowseIcon.jsx'

const SearchBar = () => {
    return (
        <div className="searchBar">
            <img src={image} alt="search icon" width={40} height={40}></img>
            <p>What do you want to play?</p>
            <div className="line"></div>
            <BrowseIcon/>
        </div>
    )
}

export default SearchBar;