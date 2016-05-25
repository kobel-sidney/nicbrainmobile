package br.com.nicbrain.util;


import br.com.nicbrain.R;

public enum CorEnum {

    AMARELO("amarelo", R.drawable.icone_amarelo),
    BRANCO("branco",R.drawable.icone_azul),
    ROXO("roxo",R.drawable.icone_roxo),
    VERDE("verde",R.drawable.icone_verde),
    VERMELHO("vermelho",R.drawable.icone_vermelho),
    DEFAULT("default",R.drawable.icone_branco);

    private String desCor;
    private Integer codCor;

    private CorEnum(final String desCor,final Integer codCor){
        this.desCor = desCor;
        this.codCor = codCor;
    }

    public static CorEnum getValue(final String desCor){
        CorEnum retorno = DEFAULT;
        for(CorEnum corEnum : values()){
            if(corEnum.getDesCor().equalsIgnoreCase(desCor)){
                retorno = corEnum;
                break;
            }
        }

        return retorno;
    }

    public String getDesCor() {
        return desCor;
    }

    public Integer getCodCor() {
        return codCor;
    }
}
