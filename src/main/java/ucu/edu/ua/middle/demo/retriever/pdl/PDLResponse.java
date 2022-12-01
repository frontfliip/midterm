package ucu.edu.ua.middle.demo.retriever.pdl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PDLResponse {
    private List<Data> data;
}


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
class Data {
    private String name;
    private String size;
    private String employee_count;
    private String facebook_url;
    private String twitter_url;
    private Location location;

}

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
class Location {
    private String street_address;
}


/*

{
    "status": 200,
    "data": [
        {
            "name": "ukrainian catholic university",
            "size": "201-500",
            "employee_count": 227,
            "id": "ukrainian-catholic-university",
            "founded": null,
            "industry": "education management",
            "naics": [
                {
                    "naics_code": "61",
                    "sector": "educational services",
                    "sub_sector": null,
                    "industry_group": null,
                    "national_industry": null
                }
            ],
            "sic": [
                {
                    "sic_code": "4899",
                    "major_group": "communications",
                    "industry_group": "communications services, not elsewhere",
                    "industry_sector": "communications services, not elsewhere classified"
                }
            ],
            "location": {
                "name": "ukraine",
                "locality": null,
                "region": null,
                "metro": null,
                "country": "ukraine",
                "continent": "europe",
                "street_address": null,
                "address_line_2": null,
                "postal_code": null,
                "geo": null
            },
            "linkedin_id": "818029",
            "linkedin_url": "linkedin.com/company/ukrainian-catholic-university",
            "facebook_url": null,
            "twitter_url": null,
            "profiles": [
                "linkedin.com/company/ukrainian-catholic-university",
                "linkedin.com/company/818029"
            ],
            "website": "ucu.edu.ua",
            "ticker": null,
            "gics_sector": null,
            "mic_exchange": null,
            "type": "private",
            "summary": "privat institution of higher education in humanities",
            "tags": null,
            "headline": null,
            "alternative_names": [
                "language school 'language express' at ukrainian catholic university",
                "ukrainian catholic university, institute of leadership and management",
                "english summer school ukrainian catholic university",
                "ukrainian catholic university / ucu",
                "lviv theological academy",
                "school of ukrainian language and culture, ukrainian catholic university",
                "ukrainian catholic education foundation (canada)",
                "the ukrainian catholic university (lviv, ukraine)",
                "leadership and managament institute at ukrainian catholic university",
                "ukrainian catholic university (lviv)"
            ],
            "affiliated_profiles": []
        }
    ],
    "scroll_token": "201$13.091693$869224",
    "total": 1
}


 */

//tVX/P71ZtF+yeJ+JG+YWDf0J0KwDuUCgBISZ0z1nyj4=