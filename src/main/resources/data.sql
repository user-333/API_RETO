-- Crear la tabla exchange_rate si no existe
CREATE TABLE exchange_rate (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    source_currency VARCHAR(3) NOT NULL,
    target_currency VARCHAR(3) NOT NULL,
    rate DECIMAL(10, 4) NOT NULL
);

-- Insertar registros de tipo de cambio
INSERT INTO exchange_rate (source_currency, target_currency, rate) 
VALUES ('USD', 'PEN', 3.8);

INSERT INTO exchange_rate (source_currency, target_currency, rate) 
VALUES ('PEN', 'USD', 0.26);
