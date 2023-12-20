import React, { useState } from "react";
import {request} from "../services/AxiosService";
import { useNavigate } from "react-router";


export default function Registro()
{
    const navigate = useNavigate();

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [formError, setFormError] = useState("");


    const onFormSubmit = e =>
    {
        e.preventDefault();

        const form = {email, password};
        request("POST", "/register/cliente", form).then(() =>
        {
            navigate("/");

            // Hacer login automaticamente
            request("POST", `/login?email=${email}&password=${password}`, {});
        })
        .catch(error =>
        {
            setFormError(error.response.data);
        });
    };


    return (
        <main className=" text-uppercase py-5">
            <hr />
            
            <div className="m-auto p-4  " 
            // shadow style={{minWidth: "40rem"}}
            >
                <div className="mb-4 text-center">
                <h5 className=" fw-normal text-uppercase ">REGISTRATE!</h5>
                <small className=" fw-light">Recibe ofertas y descuentos exclusivos por ser parte de nuestra comunidad</small>
            </div>
                <p className="small text-danger">{formError}</p>

                <form className="form-logIn form-register" onSubmit={onFormSubmit} noValidate>
                    <div className="mb-3">
                        {/* <label className="form-label" htmlFor="email">Correo electrónico</label> */}
                        <input className="form-control text-uppercase" type="text" id="email" name="email" onChange={e => setEmail(e.target.value)} placeholder="ingresa tu correo: ejemplo@email.com" required/>
                    </div>

                    <div className="mb-3">
                        {/* <label className="form-label" htmlFor="password">Contraseña</label> */}
                        <input className="form-control " type="text" id="password" name="password" placeholder="crea tu contraseña" onChange={e => setPassword(e.target.value)} required/>
                    </div>

                    <button type="submit" className="btn btn-dark  text-uppercase w-100">enviar</button>
                </form>
            </div>
        </main>
    )
}