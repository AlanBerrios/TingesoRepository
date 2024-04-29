import React, { useState, useEffect } from 'react';
import Contador from './Contador';
    
export default function Example() {
        const [contador, setContador] = useState(1);
        const [contador2, setContador2] = useState(0);
    
        function aumentarContador() {
            setContador(contador + 1);
            // setContador2(contador2 + 1);
        }

        // se ejecuta en cada renderizado
        // useEffect(() => {
        //     console.log("Se montó el componente");
        // });

        // se ejecuta solo en el primer renderizado
        // useEffect(() => {
        //     console.log("Se montó el componente");
        // },[]);
    
        // se ejecuta en renderizado inicial y cuando cambia el contador
        // useEffect(() => {
        //     console.log("Se montó el componente");
        // }, [contador]);
    
        return (
            <div>
                Contador 1
                <Contador contador={contador}/>
                Contador 2
                <Contador contador={contador2}/>
                <button onClick={aumentarContador}>Aumentar</button>
            </div>
        );
    }
    