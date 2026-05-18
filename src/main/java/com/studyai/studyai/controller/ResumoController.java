    package com.studyai.studyai.controller;

    import com.studyai.studyai.service.ResumoService;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;
    import com.studyai.studyai.dto.ResumoRequestDTO;
    import com.studyai.studyai.dto.ResumoResponseDTO;
    import jakarta.validation.Valid;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import com.studyai.studyai.dto.ResumoHistoricoDTO;
    import org.springframework.web.bind.annotation.GetMapping;
    import java.util.List;

    @RestController
    @RequestMapping("/resumos")
    public class ResumoController {
        private final ResumoService resumoService;
        public ResumoController(ResumoService resumoService) {
            this.resumoService = resumoService;
        }

        @PostMapping
        public ResumoResponseDTO gerarResumo(@Valid @RequestBody ResumoRequestDTO request) {
            return resumoService.gerarResumo(request);
        }
        @GetMapping
        public List<ResumoHistoricoDTO> listarHistorico() {
            return resumoService.listarHistorico();
        }

    }
