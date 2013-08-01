package com.tiru.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tiru.domain.Products;

@Path("/products")
public class ProductService {

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Products getXML() {
		Products prd = new Products(200, "projector", 300);
		return prd;
	}

	@GET
	@Produces({ MediaType.TEXT_HTML })
	public String getXMLHtml() {
		Products prd = new Products(200, "projector", 300);
		return "<html> " + "<title>" + "Products" + "</title>" + "<body><h1>"
				+ prd.getId() + "<br> " + prd.getDescription() + "<br>"
				+ prd.getPrice() + "</body></h1>" + "</html> ";
	}

	@GET
	@Produces({ MediaType.TEXT_XML })
	public Products getHTML() {
		Products prd = new Products(201, "tablet", 400);
		return prd;
	}

}
