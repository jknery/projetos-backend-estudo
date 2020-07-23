package br.com.ctis.hackathon.enumeration;

public enum Status
{
	ATIVO("ativo"), 
	INATIVO("inativo");
	
	private String estado;
	
	Status(String status) {
		this.estado = status;
    }
 
    public String getStatus() {
        return estado;
    }
}
