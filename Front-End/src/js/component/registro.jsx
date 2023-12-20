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
        <main className="container py-5">
            <div className="mb-4 text-center">
                <h2 className="display-6 fw-semibold text-uppercase">Crear cuenta</h2>
            </div>
            
            <div className="m-auto p-4 bg-white border rounded-3 shadow" style={{maxWidth: "40rem"}}>
                <p className="small text-danger">{formError}</p>

                <form onSubmit={onFormSubmit} noValidate>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="email">Correo electrónico</label>
                        <input className="form-control" type="text" id="email" name="email" onChange={e => setEmail(e.target.value)} placeholder="ejemplo@email.com" required/>
                    </div>

                    <div className="mb-3">
                        <label className="form-label" htmlFor="password">Contraseña</label>
                        <input className="form-control" type="password" id="password" name="password" onChange={e => setPassword(e.target.value)} required/>
                    </div>

                    <button type="submit" className="btn btn-success fw-bold w-100">Crear cuenta</button>
                </form>
            </div>
        </main>
    )
}