package com.devmonsters.cnab;

import com.devmonsters.cnab.arquivoretorno.header.Header;
import com.devmonsters.cnab.arquivoretorno.header.HeaderBradesco;
import com.devmonsters.cnab.arquivoretorno.header.HeaderCaixa;
import com.devmonsters.cnab.arquivoretorno.registro.Registro;
import com.devmonsters.cnab.arquivoretorno.registro.RegistroBradesco;
import com.devmonsters.cnab.arquivoretorno.registro.RegistroCaixa;
import com.devmonsters.cnab.arquivoretorno.trailer.Trailer;
import com.devmonsters.cnab.arquivoretorno.trailer.TrailerBradesco;
import com.devmonsters.cnab.arquivoretorno.trailer.TrailerCaixa;

public abstract class CnabFactory {

    public static Header getInstanceHeader(final Banco banco, final String linha) {
        switch (banco) {
            case CEF:
                return new HeaderCaixa(linha);
            case BRADESCO:
                return new HeaderBradesco(linha);
            default:
                return null;
        }
    }

    public static Registro getInstanceRegistro(final Banco banco, final String linha) {
        switch (banco) {
            case CEF:
                return new RegistroCaixa(linha);
            case BRADESCO:
                return new RegistroBradesco(linha);
            default:
                return null;
        }
    }

    public static Trailer getInstanceTrailer(final Banco banco, final String linha) {
        switch (banco) {
            case CEF:
                return new TrailerCaixa(linha);
            case BRADESCO:
                return new TrailerBradesco(linha);
            default:
                return null;
        }
    }
}