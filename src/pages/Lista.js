import React, {Component} from 'react';
import {api} from '../service/api';
import  'bootstrap/dist/css/bootstrap.min.css' ;
import { render } from '@testing-library/react';
 

class Lista extends Component {
    state = {
        lista:[]
    }

    async componentDidMount() {
        const response = await fetch('/pesquisa');
        const body = await response.json();
        this.setState({lista: body});

    
    }

    render(){

    
    const {lista} = this.state;

    return(
        <div className='mt-5 pt-4'>
            <table className='table'>
                <thead>
                    <tr>
                        <th scope='col'>ID</th>
                        <th scope='col'>Nome</th>
                        <th scope='col'>Data</th>
                        <th scope='col'>Tipo</th>
                    </tr>
                </thead>
                <tbody>
                    {this.state.lista && this.state.lista.map(lista =>{
                        return <tr key={lista.id}>
                            <th scope='row'>{lista.id}</th>
                            <td>{lista.nome}</td>
                            <td>{lista.data}</td>
                            <td>{lista.tipo}</td>
                        </tr>
                    })}
                </tbody>
            </table>
        </div>

    );

}
}

export default Lista;