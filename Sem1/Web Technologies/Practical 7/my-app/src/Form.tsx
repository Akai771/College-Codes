// Create a form with client-side and server-side validation
import { useState } from 'react';

export default function FormValidation() {
    const [formData, setFormData] = useState({ name: '', email: '' });
    const [errors, setErrors] = useState({ name: '', email: '' });
    const [serverMessage, setServerMessage] = useState('');

    // Client-side validation
    function validateForm() {
        const newErrors = { name: '', email: '' };
        let isValid = true;

        if (formData.name.length < 3) {
            newErrors.name = 'Name must be at least 3 characters';
            isValid = false;
        }

        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailPattern.test(formData.email)) {
            newErrors.email = 'Invalid email format';
            isValid = false;
        }
        setErrors(newErrors);
        return isValid;
    }

    function serverValidation(data: typeof formData) {
        return new Promise<string>((resolve, reject) => {
            setTimeout(() => {
                if (data.email === 'test@test.com') {
                    reject('Email already exists');
                } else {
                    resolve('Form submitted successfully!');
                }
            }, 1000);
        });
    }

    function handleSubmit(e: React.FormEvent) {
        e.preventDefault();
        setServerMessage('');

        // Client-side validation
        if (!validateForm()) {
            return;
        }

        // Server-side validation
        setServerMessage('Validating on server...');
        serverValidation(formData)
            .then((message) => {
                setServerMessage(message);
                setFormData({ name: '', email: '' });
            })
            .catch((error: string) => {
                setServerMessage(error);
            });
    }

    function handleChange(e: React.ChangeEvent<HTMLInputElement>) {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    }

    return (
        <>
            <h2>Form with Validation</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Name: </label>
                    <input type="text" name="name" value={formData.name} onChange={handleChange} />
                    {errors.name && <p style={{color: 'red'}}>{errors.name}</p>}
                </div>
                <div>
                    <label>Email: </label>
                    <input type="text" name="email" value={formData.email} onChange={handleChange} />
                    {errors.email && <p style={{color: 'red'}}>{errors.email}</p>}
                </div>
                <button type="submit">Submit</button>
            </form>
            {serverMessage && (<p style={{color: serverMessage.includes('success') ? 'green' : 'orange'}}>{serverMessage}</p>)}
        </>
    );
}