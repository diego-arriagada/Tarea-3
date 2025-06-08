package org.tarea3;

public class Wallet{
    private Deposito<Moneda> deposito;
    private int ValorWallet;

    public Wallet(){
        this.ValorWallet = 0;
        this.deposito = new Deposito<Moneda>();

    }

    public int getvalorWallet(){
        this.ValorWallet = 0;
        for(int i=0;i<deposito.deposito.size();i++){
            this.ValorWallet = ValorWallet + deposito.deposito.get(i).getValor();
        }
        return this.ValorWallet;
    }

    public void eliminarMoneda(Moneda m) {
        deposito.eliminarObjeto(m);

    }


    public void vaciarWallet(){
        deposito.deposito.clear(); // Asumiendo que deposito.deposito es LinkedList o similar
    }


    public void addMoneda(Moneda m){
        deposito.addObjeto(m);
    }

    public Deposito<Moneda> getDepositoMoneda(){
        return deposito;
    }

}
