class ErroDeValor extends RuntimeException {
    public ErroDeValor(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}

class FalhaOperacional extends RuntimeException {
    public FalhaOperacional(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}
