package com.studyai.studyai.service;

import com.studyai.studyai.dto.ResumoRequestDTO;
import com.studyai.studyai.dto.ResumoResponseDTO;
import org.springframework.stereotype.Service;
import java.util.List;
import com.studyai.studyai.entity.Resumo;
import com.studyai.studyai.repository.ResumoRepository;
import java.time.LocalDateTime;
import com.studyai.studyai.dto.ResumoHistoricoDTO;


@Service
public class ResumoService {
    private final ResumoRepository resumoRepository;

    public ResumoService(ResumoRepository resumoRepository) {
        this.resumoRepository = resumoRepository;
    }

    public ResumoResponseDTO gerarResumo(ResumoRequestDTO request) {
        String texto = request.getConteudo();

        String resumoGerado = gerarResumoMockado(texto);

        List<String> perguntasGeradas = gerarPerguntasMockadas(request.getTitulo(), texto);

        Resumo resumo = new Resumo();
        resumo.setTitulo(request.getTitulo());
        resumo.setConteudoOriginal(texto);
        resumo.setResumoGerado(resumoGerado);
        resumo.setCriadoEm(LocalDateTime.now());

        resumoRepository.save(resumo);

        ResumoResponseDTO response = new ResumoResponseDTO();
        response.setTitulo(request.getTitulo());
        response.setResumo(resumoGerado);
        response.setPerguntas(perguntasGeradas);

        return response;
    }
    public List<ResumoHistoricoDTO> listarHistorico() {
        return resumoRepository.findAll()
                .stream()
                .map(this::converterParaHistoricoDTO)
                .toList();
    }

    private ResumoHistoricoDTO converterParaHistoricoDTO(Resumo resumo) {
        ResumoHistoricoDTO dto = new ResumoHistoricoDTO();

        dto.setId(resumo.getId());
        dto.setTitulo(resumo.getTitulo());
        dto.setResumo(resumo.getResumoGerado());
        dto.setCriadoEm(resumo.getCriadoEm());

        return dto;
    }

    private String gerarResumoMockado(String texto) {
        String textoLimpo = texto.trim();
        if (textoLimpo.length() <= 120) {
            return "Resumo: " + textoLimpo;
        }
        String trechoInicial = textoLimpo.substring(0, 120);
        return "Resumo: " + trechoInicial + "...";
    }
    private List<String> gerarPerguntasMockadas(String titulo, String texto) {

        String textoMinusculo = texto.toLowerCase();

        if (textoMinusculo.contains("encapsulamento")
                || textoMinusculo.contains("herança")
                || textoMinusculo.contains("polimorfismo")
                || textoMinusculo.contains("abstração")) {

            return List.of(
                    "O que é encapsulamento no contexto da programação orientada a objetos?",
                    "Qual é a diferença entre herança e polimorfismo?",
                    "Como a abstração ajuda na organização do código?"
            );
        }

        if (textoMinusculo.contains("spring boot")
                || textoMinusculo.contains("api")
                || textoMinusculo.contains("backend")) {

            return List.of(
                    "Qual é o papel do Spring Boot no desenvolvimento backend?",
                    "Como uma API ajuda na comunicação entre sistemas?",
                    "Quais benefícios uma arquitetura backend organizada oferece?"
            );
        }

        if (textoMinusculo.contains("inteligência artificial")
                || textoMinusculo.contains("ia")
                || textoMinusculo.contains("machine learning")) {

            return List.of(
                    "Qual é a ideia principal sobre inteligência artificial apresentada no texto?",
                    "Como a IA pode ser aplicada em soluções educacionais?",
                    "Quais cuidados devem ser considerados ao usar IA?"
            );
        }

        return List.of(
                "Qual é a ideia principal de " + titulo + "?",
                "Quais são os conceitos mais importantes apresentados no conteúdo?",
                "Como esse conteúdo pode ser aplicado na prática?"
        );
    }



}
