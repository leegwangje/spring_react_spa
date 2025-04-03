import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import './styles/index.css';
import App from './App.jsx';
import {AuthProvider} from "./contexts/AuthContext.jsx";

const rootElement = document.getElementById('root');

if (rootElement) {
    createRoot(rootElement).render(
        // 무결성 체크 때문에 insert시 2씩 증가
        <StrictMode>
            <AuthProvider>
            <App />
            </AuthProvider>
        </StrictMode>
    );
} else {
    console.error("Root element not found");
}
