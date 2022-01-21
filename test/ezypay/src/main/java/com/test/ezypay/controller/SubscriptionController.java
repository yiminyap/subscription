package com.test.ezypay.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.test.ezypay.domain.Details;
import com.test.ezypay.domain.subscriptionOutput;
import com.test.ezypay.enumclass.subscriptionType;
import com.test.ezypay.util.DateUtil;

@Controller
public class SubscriptionController {

	@GetMapping("/subscription")
	public String subscription(Model model) {		
		
		Details details= new Details();
		model.addAttribute("details", details);
		return "index";
	}
	
	@RequestMapping(value="/subscription", method=RequestMethod.POST)
	public ModelAndView submitForm(@ModelAttribute Details details) throws ParseException {	
		ModelAndView modelandview = new ModelAndView();
		subscriptionOutput detailsOutput= new subscriptionOutput();
		detailsOutput = handleSubscriptionType(details);
		modelandview.setViewName("output");
		modelandview.addObject("detailsOutput", detailsOutput); 
		return modelandview;
	}

	public subscriptionOutput handleSubscriptionType(Details details) {

		long diffDays = 1;
		Set<String> invoiceDates = new LinkedHashSet<>();
		if (details.getSubscriptionType().equals(subscriptionType.DAILY.name())) {
			diffDays = 1;
			invoiceDates = DateUtil.process(DateUtil.stringToDate(details.getStartDate()),
					DateUtil.stringToDate(details.getEndDate()), diffDays);
			
		} else if (details.getSubscriptionType().equals(subscriptionType.WEEKLY.name())) {
			diffDays = 7;
			Date dt = DateUtil.getWeekOfDay(details.getStartDate(), details.getDayOfWeek());
			invoiceDates = DateUtil.process(dt,
					DateUtil.stringToDate(details.getEndDate()), diffDays);
			
		} else if (details.getSubscriptionType().equals(subscriptionType.MONTHLY.name())) {
			diffDays = 30;
			Date dt = DateUtil.getMonthOfDay(details.getStartDate(),Integer.parseInt(details.getDayOfMonth()));
			invoiceDates = DateUtil.process(dt,
					DateUtil.stringToDate(details.getEndDate()), diffDays);
		}
		subscriptionOutput output = new subscriptionOutput(details.getAmount(), details.getSubscriptionType(),
				invoiceDates);
		
		return output;
	}
	
}
