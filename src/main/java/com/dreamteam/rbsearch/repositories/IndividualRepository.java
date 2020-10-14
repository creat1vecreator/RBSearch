package com.dreamteam.rbsearch.repositories;

import com.dreamteam.rbsearch.entities.IndividualEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IndividualRepository extends JpaRepository<IndividualEntity, Long> {

    Optional<IndividualEntity> findById(Long id);

    Optional<IndividualEntity> findByName(String name);

    List<IndividualEntity> findAllByTransferTypesContaining(List<String> transfer_type);

    List<IndividualEntity> findAllByTransferAutoEquals(Boolean transfer_auto);

    List<IndividualEntity> findAllByTransferCurrencyContaining(List<String> transfer_currency);

    List<IndividualEntity> findAllByPaymentMethodContaining(List<String> payment_method);

    List<IndividualEntity> findAllByPaymentAimsServicesContaining(List<String> payment_aims_services);

    List<IndividualEntity> findAllByPaymentAutoEquals(Boolean payment_auto);

    List<IndividualEntity> findAllByDepositRateStartGreaterThanAndDepositRateFinishLessThan(Float deposit_rate_start, Float deposit_rate_finish);

    List<IndividualEntity> findAllByDepositCurrencyContaining(List<String> deposit_currency);

    List<IndividualEntity> findAllByDepositAdditionalConditionsContaining(List<String> deposit_additional_conditions);

    List<IndividualEntity> findAllByConsultationContaining(List<String> consultation);

    List<IndividualEntity> findAllByCardFreeServiceEquals(Boolean card_free_service);

    List<IndividualEntity> findAllByCardTypesContaining(List<String> card_types);

    List<IndividualEntity> findAllByCardCategoriesContaining(List<String> card_categories);

    List<IndividualEntity> findAllByCardAnnualServicePriceStartGreaterThanAndCardAnnualServicePriceFinishLessThan(Integer card_annual_service_price_start, Integer card_annual_service_price_finish);

    List<IndividualEntity> findAllByCardCashbackStartGreaterThanAndCardCashbackFinishLessThan(Float card_cashback_start, Float card_cashback_finish);

    List<IndividualEntity> findAllByCardDesignToChooseEquals(Boolean card_design_to_choose);

    List<IndividualEntity> findAllByCardValidityStartGreaterThanAndCardValidityFinishLessThan(Integer card_validity_start, Integer card_validity_finish);

    List<IndividualEntity> findAllByCreditAimContaining(List<String> credit_aim);

    List<IndividualEntity> findAllByCreditInterestRateStartGreaterThanAndCreditInterestRateFinishLessThan(Float credit_interest_rate_start, Float credit_interest_rate_finish);

    List<IndividualEntity> findAllByCreditTermStartGreaterThanAndCreditTermFinishLessThan(Integer credit_term_start, Integer credit_term_finish);

    List<IndividualEntity> findAllByCreditEarlyPaymentEquals(Boolean credit_early_payment);

    List<IndividualEntity> findAllByCreditAmountStartGreaterThanAndCreditAmountFinishLessThan(Integer credit_amount_start, Integer credit_amount_finish);

    List<IndividualEntity> findAllByInsuranceAimContaining(List<String> insurance_aim);

    List<IndividualEntity> findAllByInsuranceAmountStartGreaterThanAndInsuranceAmountFinishLessThan(Integer insurance_amount_start, Integer insurance_amount_finish);

    List<IndividualEntity> findAllOrderedByRatingGreaterThan(Float rating); // not-ordered

    List<IndividualEntity> findAllByPopularityGreaterThan(Integer popularity); // not-ordered

    List<IndividualEntity> findAllByUniqueServicesContaining(List<String> unique_services);
}
