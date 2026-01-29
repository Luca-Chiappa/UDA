import { useState } from "react"

export default function Navbar(){

    const [isOpen, setIsOpen] = useState<boolean>(false);
    return(
        <div className="">
            <div className="">
                <h1 className="bg-red-500 font-bold ">Macchiavelli</h1>
            </div>
            <div className="">
                <h2 className="bg-white font-light">DATI</h2>
            </div>
            <div className="">
                <h2 className="bg-white font-light">DASHBOARD</h2>
            </div>
        </div>
    )
}