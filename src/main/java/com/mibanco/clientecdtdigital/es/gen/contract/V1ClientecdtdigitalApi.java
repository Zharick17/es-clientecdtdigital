package com.mibanco.clientecdtdigital.es.gen.contract;

import com.mibanco.clientecdtdigital.es.gen.type.ClienteCDTDigitalType;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;




import java.io.InputStream;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;


@Path("/v1/es")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-03-26T10:45:13.406409800-05:00[America/Bogota]", comments = "Generator version: 7.4.0")
public interface V1ClientecdtdigitalApi {

    @GET
    @Path("/buscarClienteCDT/{id_cliente}")
    @Produces({ "application/json" })
    Response buscarClienteCDTDigital(@PathParam("id_cliente") @Min(1) Integer idCliente);

    @POST
    @Path("/clienteCDT")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response crearClienteCDTDigital(@Valid ClienteCDTDigitalType clienteCDTDigitalType);

    @PUT
    @Path("/editarClienteCDT/{id_cliente}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response editarClienteCDTDigital(@PathParam("id_cliente") @Min(1) Integer idCliente,@Valid ClienteCDTDigitalType clienteCDTDigitalType);

    @DELETE
    @Path("/eliminarClienteCDT/{id_cliente}")
    Response eliminarClienteCDT(@PathParam("id_cliente") @Min(1) Integer idCliente);
}
