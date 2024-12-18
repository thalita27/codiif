public class BancoConta {

    private int idConta;
    private String titular;
    private double saldoAtual;
    private double limiteParaSaque;

    public BancoConta(int idConta, String titular, double saldoInicial, double limiteParaSaque) {
        this.idConta = idConta;
        this.titular = titular;
        this.saldoAtual = saldoInicial;
        this.limiteParaSaque = limiteParaSaque;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(double saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    public double getLimiteParaSaque() {
        return limiteParaSaque;
    }

    public void setLimiteParaSaque(double limiteParaSaque) {
        this.limiteParaSaque = limiteParaSaque;
    }

    public void realizarSaque(double valor) {
        validarValorPositivo(valor);
        if (valor > saldoAtual) {
            throw new ErroDeContaException("Saldo insuficiente para realizar o saque.");
        }
        if (valor > limiteParaSaque) {
            throw new ErroDeContaException("O valor excede o limite permitido para saque.");
        }
        saldoAtual -= valor;
        System.out.println("Saque realizado com sucesso! Saldo atualizado: R$ " + saldoAtual);
    }

    public void adicionarDeposito(double valor) {
        validarValorPositivo(valor);
        saldoAtual += valor;
        System.out.println("Depósito efetuado! Saldo atualizado: R$ " + saldoAtual);
    }

    private void validarValorPositivo(double valor) {
        if (valor <= 0) {
            throw new ErroDeValorInvalidoException("O valor deve ser maior que zero.");
        }
    }
}
