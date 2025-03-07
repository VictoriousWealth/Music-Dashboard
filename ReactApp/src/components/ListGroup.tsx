import { useState } from "react";

interface Props {
    items: string[];
    heading: string;
    onSelectItem: (item: string) => void;
}

function ListGroup({items, heading, onSelectItem}: Props) {

    
    const [selctedIndex, setSelectedIndex] = useState(-1);


    //event handler
    const handleClick = (event: MouseEvent) => console.log(event);
    
    return <>
        <h1>{heading}</h1>
        <ul className="list-group">
            {items.map((item, index) => 
            <li
                className={selctedIndex === index 
                    ? "list-group-item active"
                    : "list-group-item"
                }
                key={item}
                onClick={
                    () => {
                        setSelectedIndex(index);
                        onSelectItem(item);
                    }
                } 
            > 
                {item}
            </li>)}
        </ul>
    </>
}

export default ListGroup