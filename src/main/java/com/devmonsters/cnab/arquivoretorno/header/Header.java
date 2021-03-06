package com.devmonsters.cnab.arquivoretorno.header;

import java.util.Date;

public abstract class Header {
    
    private final String linha;
    
    public Header(final String linha) {
        if (!linha.startsWith(this.getCodigoRegistro())) {
            throw new IllegalArgumentException(String.format("Header come\u00e7aa com %s", this.getCodigoRegistro()));
        }
        this.linha = linha;
    }
    
    public String getLinha() {
        return this.linha;
    }
    
    public String getCodigoRegistro() {
        return "0";
    }
    
    public int getCodigoRetorno() {
        return Integer.valueOf(this.linha.substring(1, 2));
    }
    
    public String getLiteralRetorno() {
        return this.linha.substring(2, 9);
    }
    
    public String getCodigoServico() {
        return this.linha.substring(9, 11);
    }
    
    public abstract String getLiteralServico();
    
    public abstract String getCodigoEmpresa();
    
    public abstract String getNomeEmpresa();
    
    public abstract String getCodigoBanco();
    
    public abstract String getNomeBanco();
    
    public abstract Date getDataGravacao();
    
    public abstract int getNumeroSequencial();
}