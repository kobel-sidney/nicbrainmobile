package br.com.nicbrain.util;

/**
 * Created by hamseshenrique on 20/10/15.
 */
public enum OrdenacaoListEnum {

    VAZIO(0,""),
    ITEM(1,""),
    RESPONSAVEL(2,"Responsavel"),
    STATUS(3,"Status");

    private Integer codigo;
    private String descricao;

    private OrdenacaoListEnum(final Integer codigo, final String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static OrdenacaoListEnum fromCodigo(final Integer codigo){
        OrdenacaoListEnum retorno = OrdenacaoListEnum.ITEM;

        for(OrdenacaoListEnum ordenacaoListEnum :values()){
            if(ordenacaoListEnum.getCodigo().equals(codigo)){
                retorno = ordenacaoListEnum;
                break;
            }
        }

        return retorno;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
