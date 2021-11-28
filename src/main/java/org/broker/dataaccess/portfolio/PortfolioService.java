package org.broker.dataaccess.portfolio;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    @Transactional
    public void bulkUpset(final List<PortfolioEntity> portfolioEntityList) {
        portfolioEntityList.forEach(portfolioRepository::save);
    }

    public List<Portfolio> getAllPortfolios() {
        return portfolioRepository.findAllDTO();
    }
}
