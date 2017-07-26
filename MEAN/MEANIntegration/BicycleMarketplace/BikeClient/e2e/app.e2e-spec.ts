import { BikeClientPage } from './app.po';

describe('bike-client App', () => {
  let page: BikeClientPage;

  beforeEach(() => {
    page = new BikeClientPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
