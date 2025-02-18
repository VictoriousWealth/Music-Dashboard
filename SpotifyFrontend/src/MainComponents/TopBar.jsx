import React from "react";
import Logo from '../TopBarComponents/Logo.jsx';
import HomeLogoLink from '../TopBarComponents/HomeLogoLink.jsx';
import SearchBlackBox from '../TopBarComponents/SearchBlackBox.jsx';
import BrowseLogoButton from '../TopBarComponents/BrowseLogoButton.jsx';
import NotificationsLogoButton from '../TopBarComponents/NotificationsLogoButton.jsx';
import AccountLogoButton from '../TopBarComponents/AccountLogoButton.jsx';

import '../CSS/TopBar.css'

const TopBar = () => {
    return (
        <div className="top-bar">
            <Logo/>
            <HomeLogoLink/>
            <SearchBlackBox/>
            <BrowseLogoButton/>
            <NotificationsLogoButton/>
            <AccountLogoButton/>
        </div>
    )
}

export default TopBar;