package com.mibanco.clientecdtdigital.es.services.contract;

import com.mibanco.clientecdtdigital.es.gen.type.ClienteCDTDigitalType;
import jakarta.ws.rs.core.Response;

public interface IClienteCDTDigital {
    ClienteCDTDigitalType crearClienteCDTDigital(ClienteCDTDigitalType clienteCDTDigitalType);
    ClienteCDTDigitalType buscarClienteCDTDigital(Integer idCliente);
    void eliminarClienteCDT(Integer idCliente);
    ClienteCDTDigitalType editarClienteCDTDigital(Integer idCliente, ClienteCDTDigitalType clienteCDTDigitalType);
}
