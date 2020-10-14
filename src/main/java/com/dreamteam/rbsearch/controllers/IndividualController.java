package com.dreamteam.rbsearch.controllers;

import com.dreamteam.rbsearch.BankEntitiesDTO.BankEntitiesDTO;
import com.dreamteam.rbsearch.entities.IndividualEntity;
import com.dreamteam.rbsearch.form.IndividualForm;
import com.dreamteam.rbsearch.services.IndividualService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/individual")
public class IndividualController {
    private final IndividualService individualService;


    // todo change Containing and Contains or something else

//    @GetMapping("/criteria")
//    public String returnSearchPage() {
//        return "criteria/individual";
//    }

//    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json")
//    public ResponseEntity<String> getSearch(
//            @RequestParam(value = "price") String price,
//            @RequestParam(value = "app", required = false) String app) {
//        IndividualForm individualForm = new IndividualForm(
//                price,
//                app
//        );
//        System.out.println(individualForm);
//        BankEntitiesDTO<IndividualEntity> bankEntitiesDTO = individualService.find(individualForm);
//        String jsonResponse = new Gson().toJson(bankEntitiesDTO.getBankEntities());
//        System.out.println(jsonResponse);
//        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
//    }

    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json")
    public String getSearch(
            Model model,
            @RequestParam(value = "transfer_types", required = false) String transferTypes,
            @RequestParam(value = "transfer_auto", required = false) String transferAuto,
            @RequestParam(value = "transfer_currency", required = false)String transferCurrency,
            @RequestParam(value = "transfer_method", required = false) String paymentMethod,
            @RequestParam(value = "payment_aims_services", required = false) String paymentAimsServices,
            @RequestParam(value = "payment_auto", required = false) String paymentAuto,
            @RequestParam(value = "deposit_rate_start") String depositRateStart,
            @RequestParam(value = "deposit_rate_finish") String depositRateFinish,
            @RequestParam(value = "deposit_currency", required = false) String depositCurrency,
            @RequestParam(value = "deposit_additional_conditions",required = false) String depositAdditionalConditions,
            @RequestParam(value = "consultation", required = false) String consultation,
            @RequestParam(value = "card_free_serice", required = false) String cardFreeService,
            @RequestParam(value = "card_types", required = false) String cardTypes,
            @RequestParam(value = "card_categories", required = false) String cardCategories,
            @RequestParam(value = "card_annual_service_price_start") String cardAnnualServicePriceStart,
            @RequestParam(value = "card_annual_service_price_finish") String cardAnnualServicePriceFinish,
            @RequestParam(value = "card_cahsback_start") String cardCashbackStart,
            @RequestParam(value = "card_cashback_finish") String cardCashbackFinish,
            @RequestParam(value = "card_design_to_choose", required = false) String cardDesignToChoose,
            @RequestParam(value = "card_validity_start") String cardValidityStart,
            @RequestParam(value = "card_validity_finish") String cardValidityFinish,
            @RequestParam(value = "credit_aim", required = false) String creditAim,
            @RequestParam(value = "credit_interest_rate_start") String creditInterestRateStart,
            @RequestParam(value = "credit_interest_rate_finish") String creditInterestRateFinish,
            @RequestParam(value = "credit_term_start") String creditTermStart,
            @RequestParam(value = "credit_term_finish") String creditTermFinish,
            @RequestParam(value = "credit_early_payment", required = false) String creditEarlyPayment,
            @RequestParam(value = "credit_amount_start") String creditAmountStart,
            @RequestParam(value = "credit_amount_finish") String creditAmountFinish,
            @RequestParam(value = "insurance_aim", required = false) String insuranceAim,
            @RequestParam(value = "insurance_amount_start") String insuranceAmountStart,
            @RequestParam(value = "insurance_amount_finish") String insuranceAmountFinish,
            @RequestParam(value = "rating", required = false) String sorting,
            @RequestParam(value = "unique_services", required = false) String uniqueServices) {
        IndividualForm individualForm = new IndividualForm(
                transferTypes,
                transferAuto,
                transferCurrency,
                paymentMethod,
                paymentAimsServices,
                paymentAuto,
                depositRateStart,
                depositRateFinish,
                depositCurrency,
                depositAdditionalConditions,
                consultation,
                cardFreeService,
                cardTypes,
                cardCategories,
                cardAnnualServicePriceStart,
                cardAnnualServicePriceFinish,
                cardCashbackStart,
                cardCashbackFinish,
                cardDesignToChoose,
                cardValidityStart,
                cardValidityFinish,
                creditAim,
                creditInterestRateStart,
                creditInterestRateFinish,
                creditTermStart,
                creditTermFinish,
                creditEarlyPayment,
                creditAmountStart,
                creditAmountFinish,
                insuranceAim,
                insuranceAmountStart,
                insuranceAmountFinish,
                sorting,
                uniqueServices
        );
        System.out.println(individualForm);
        BankEntitiesDTO<IndividualEntity> bankEntitiesDTO = individualService.find(individualForm);
        model.addAttribute("banks", bankEntitiesDTO.getBankEntities());
        return "answer/individual";
    }

//    @GetMapping("/bank/{name}")
//    public @ResponseBody ResponseEntity<String> findByName(@PathVariable String name, Model model) {
//        try {
//            IndividualEntity individualEntity = individualService.findByName(name);
//            String jsonResponse = new Gson().toJson(individualEntity);
//            System.out.println(jsonResponse);
//            return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
//        } catch (RuntimeException runtimeException) {
//            return new ResponseEntity<>("error 404 - not found", HttpStatus.OK);
//        }
//    }

    @GetMapping("/bank/{name}")
    public String findByName(@PathVariable String name, Model model) {
        try {
            IndividualEntity individualEntity = individualService.findByName(name);
            model.addAttribute("bank", individualEntity);
            return "single/individual";
        } catch (RuntimeException runtimeException) {
            return "error";
        }
    }

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<String> getAllBanks() {
        BankEntitiesDTO<IndividualEntity> bankEntitiesDTO = individualService.findAll();
        String jsonResponse = new Gson().toJson(bankEntitiesDTO);
        System.out.println(jsonResponse);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }
}
