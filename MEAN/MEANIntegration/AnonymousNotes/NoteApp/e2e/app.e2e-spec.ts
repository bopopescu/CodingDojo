import { NoteAppPage } from './app.po';

describe('note-app App', () => {
  let page: NoteAppPage;

  beforeEach(() => {
    page = new NoteAppPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
