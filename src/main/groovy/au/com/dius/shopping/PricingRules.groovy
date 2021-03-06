package au.com.dius.shopping

import au.com.dius.shopping.pricingRules.PricingRule
import au.com.dius.shopping.pricingRules.FreeVGAAdapterWithMacBookProPricingRule
import au.com.dius.shopping.pricingRules.SuperIPadBulkDiscountPricingRule
import au.com.dius.shopping.pricingRules.ThreeForTwoAppleTVsPricingRule

class PricingRules {
    List<PricingRule> pricingRules = []

    PricingRules() {
        pricingRules << new FreeVGAAdapterWithMacBookProPricingRule()
        pricingRules << new SuperIPadBulkDiscountPricingRule()
        pricingRules << new ThreeForTwoAppleTVsPricingRule()
    }

    void applyRules(List<Item> items) {
        if (items) {
            pricingRules.findAll { it.isValid() }.each { it.applyRule(items) }
        }
    }
}
